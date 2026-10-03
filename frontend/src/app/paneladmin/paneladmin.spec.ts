import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Paneladmin } from './paneladmin';

describe('Paneladmin', () => {
  let component: Paneladmin;
  let fixture: ComponentFixture<Paneladmin>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Paneladmin],
    }).compileComponents();

    fixture = TestBed.createComponent(Paneladmin);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
