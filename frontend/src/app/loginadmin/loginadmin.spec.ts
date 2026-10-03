import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Loginadmin } from './loginadmin';

describe('Loginadmin', () => {
  let component: Loginadmin;
  let fixture: ComponentFixture<Loginadmin>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Loginadmin],
    }).compileComponents();

    fixture = TestBed.createComponent(Loginadmin);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
