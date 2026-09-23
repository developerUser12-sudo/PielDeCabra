import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Avisolegal } from './avisolegal';

describe('Avisolegal', () => {
  let component: Avisolegal;
  let fixture: ComponentFixture<Avisolegal>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Avisolegal],
    }).compileComponents();

    fixture = TestBed.createComponent(Avisolegal);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
