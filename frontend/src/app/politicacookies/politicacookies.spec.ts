import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Politicacookies } from './politicacookies';

describe('Politicacookies', () => {
  let component: Politicacookies;
  let fixture: ComponentFixture<Politicacookies>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Politicacookies],
    }).compileComponents();

    fixture = TestBed.createComponent(Politicacookies);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
